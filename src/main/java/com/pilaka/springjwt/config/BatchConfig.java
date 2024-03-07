package com.pilaka.springjwt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
	@Autowired
	private final EmployeeRepository repository;
	@Autowired
	private final JobRepository jobRepository;
	@Autowired
	private final PlatformTransactionManager  platformTransactionManager;
	@Bean
	public FlatFileItemReader<Employee> itemReader() {
		FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<Employee>();
		try {
			//itemReader.setResource(new FileSystemResource("/src/main/resources/employeedata.csv"));
			itemReader.setResource(new FileSystemResource("X:\\eclipse2023-work-space-git-repo\\git-batch-jobs\\src\\main\\resources\\employeedata.csv"));		
			itemReader.setName("csvReader");
			itemReader.setLineMapper(lineMapper());
			itemReader.setLinesToSkip(1);
			System.out.println(itemReader.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return itemReader;		
	}
	private LineMapper<Employee> lineMapper(){
	
		DefaultLineMapper<Employee> employees = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTockenizer = new DelimitedLineTokenizer();
		lineTockenizer.setDelimiter(",");
		lineTockenizer.setStrict(false);
		lineTockenizer.setNames("employee_id","employee_Name","email","gender");
		BeanWrapperFieldSetMapper <Employee> fieldsMapper = new BeanWrapperFieldSetMapper<Employee>();
		fieldsMapper.setTargetType(Employee.class);
		employees.setLineTokenizer(lineTockenizer);
		employees.setFieldSetMapper(fieldsMapper);
		return employees;
	}
	@Bean
	public RepositoryItemWriter<Employee> writer () {
		RepositoryItemWriter<Employee> writer = new RepositoryItemWriter<>();
		writer.setRepository(repository);
		writer.setMethodName("save");	
		return writer;
	}
	
	@Bean
	public EmployeeProcesser processer() {
		System.out.println("4-processer");
		return new EmployeeProcesser();
	}
	@Bean
	public Step importStep() throws Exception {
		return new StepBuilder("csvImport3",jobRepository)
			   .<Employee, Employee>chunk(5,platformTransactionManager)
			   .reader(itemReader())
			   .processor(processer())
			   .writer(writer())
			   .build();
	}
	@Bean
	public Job runJob() throws Exception {
	return new JobBuilder("importEmployees", jobRepository)
				   .start(importStep())
				   .build();
		
	}
	
	//for running parallel threads to run the batch job
	@Bean
	public TaskExecutor myTaskExecutor() {
		
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(5);
		return asyncTaskExecutor;
		
	}
	
}
