package com.barosanu.emplapp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.barosanu.emplapp.dbaccess.IDataBaseAccess;
import com.barosanu.emplapp.model.User;
import com.barosanu.emplapp.model.UserDetails;
import com.barosanu.emplapp.model.WorkingPossition;

@RunWith(MockitoJUnitRunner.class) // instantiates mocks
public class ProjectTest {

	private Project project;
	@Mock
	private IDataBaseAccess iDataBaseAccessMock;

	@Before
	public void setUp() {
		project = new Project("SomeProject", iDataBaseAccessMock);
	}

	@Test
	public void testGetUserDetails() {
		User someUser = new User(20, "someUser", WorkingPossition.JUNIOR_DEVELOPER);
		UserDetails someUserDetails = new UserDetails();
		
		when(iDataBaseAccessMock.getUserDetails(Matchers.any(User.class))).thenReturn(someUserDetails);
		UserDetails expectedUserDetails = project.getUserDetails(someUser);
		verify(iDataBaseAccessMock, times(1)).getUserDetails(someUser);
		
		assertEquals(expectedUserDetails, someUserDetails);		
	}

	@Test // Useless test!!
	public void testFields() {
		assertEquals("SomeProject", project.getName());
	}

	@Test
	public void testAddUser() {
		User user = new User();
		project.addUser(user);
		assertThat(project.getUsers(), containsInAnyOrder(user));
		assertThat(project.getUsers(), hasSize(1));
	}

	@Test
	public void testAddUserSimple() {
		User user = new User();
		project.addUser(user);
		assertTrue(project.getUsers().contains(user));
		assertEquals(project.getUsers().size(), 1);
	}

	@Test
	public void testGetUsersByWorkingPossition() {
		User user1 = new User(20, "", WorkingPossition.JUNIOR_DEVELOPER);
		User user2 = new User(20, "", WorkingPossition.PROJECT_MANAGER);
		User user3 = new User(20, "", WorkingPossition.SENIOR_SOFTWARE_ENGINEER);
		User user4 = new User(20, "", WorkingPossition.SOFTWARE_ENGINEER);
		User user5 = new User(20, "", WorkingPossition.JUNIOR_DEVELOPER);

		project.addUsers(user1, user2, user3, user4, user5);
		List<User> juniors = new ArrayList<User>();
		juniors.add(user1);
		juniors.add(user5);
		assertEquals(project.getUsersWithPossition(WorkingPossition.JUNIOR_DEVELOPER), juniors);
	}

}
