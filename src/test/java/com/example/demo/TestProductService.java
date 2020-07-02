package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.modal.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class TestProductService {


	  @InjectMocks
	  ProductService productService;
	     
	    @Mock
	    ProductRepository repo;
	
	    
	 @Before
	public void init()  {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListAll() {
		  List<Product> list = new ArrayList<Product>();
		  Product empOne = new Product(1, "John", 100.45f);
		  Product empTwo = new Product(2, "Alex", 500.34f);
		  Product empThree = new Product(3, "Steve", 56.23f);
	         
	        list.add(empOne);
	        list.add(empTwo);
	        list.add(empThree);
	        when(repo.findAll()).thenReturn(list);
	        //test
	        List<Product> pList = productService.listAll();
	        
	        assertEquals(3, pList.size());
	        verify(repo, times(1)).findAll();
	}
@Test
	public void testGetProductById() {
		when(repo.findById(1).orElse(null)).thenReturn(new Product(1,"test",12.56f));
		Product prod= productService.get(1);
		assertEquals("1",prod.getId());
		assertEquals("test",prod.getName());
		assertEquals(12.56f,prod.getPrice());
		
	}
	

}
