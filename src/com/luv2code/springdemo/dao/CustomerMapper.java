package com.luv2code.springdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerMapper {

	// xmlファイルではなく、直接SQLをかく。複雑なものの場合は向いてない。改行できないし。
	@Select("select * from customer")
	public List<Customer> getCustomers();

	@Select("select * from customer where id = #{theId}")
	public Customer getCustomer(int theId);

	@Insert("insert into customer (first_Name, last_Name, email) value (#{firstName}, #{lastName}, #{email})")
	public void saveCustomer(Customer theCustomer);

	@Delete("delete from customer where id = #{theId}")
	public void deleteCustomer(int theId);
}
