package com.niit.backend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBackEnd.dao.CategoryDAO;
import com.niit.EcomBackEnd.dto.Category;

@SuppressWarnings("unused")
public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.EcomBackEnd");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	
/*	  @Test public void testAddCategory() {
	  
	  category = new Category(); category.setName("Mobile");
	  category.setDescription("This is some description for Mobile");
	  category.setImageURL("CAT_106.png");
	  
	  assertEquals("Successfully added a category inside the table!",true,
	  categoryDAO.add(category));
	  
	  }*/
	 
	 
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!"
	 * ,"Television",category.getName());
	 * 
	 * }
	 */

/*	@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(1);
		
		category.setName("Laptop");

		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));

	}
*/
	
/*	@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));

	}*/

	
/*	@Test
	public void testListCategory() {

		assertEquals("Successfully fetched the list of categories from the table!",2, categoryDAO.list().size());

	}*/
	/*
	@Test
	public void testCRUDCategory() {
		
		
		//add operation
		category = new Category(); category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_1.png");
		  
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		category = new Category(); category.setName("Television");
		category.setDescription("This is some description for TV");
		category.setImageURL("CAT_2.png");
		  
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		//fetch and update the category
		category = categoryDAO.get(2);
		
		category.setName("Television");

		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));

		
		//delete the category
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));

		
		//fetching the list of categories
		assertEquals("Successfully fetched the list of categories from the table!",2, categoryDAO.list().size());
		
	}
	*/
}
