package com.cts.superstore.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cts.superstore.model.GenerateReportModel;
import com.cts.superstore.service.GenerateReportServiceImplemenation;


@RunWith(SpringJUnit4ClassRunner.class)
public class GenerateReportControllerTest {

	@InjectMocks
	private GenerateReportController controller;
	
	@Mock
	private GenerateReportServiceImplemenation service;
	
	@Test
	public void testGetCustomerUpdatedByDate() throws Exception {
		List<GenerateReportModel> reportList=new ArrayList<GenerateReportModel>();
		LocalDate today=LocalDate.now();
		reportList.add(new GenerateReportModel(5,1234, "hameem", "phone", "home", "9-12", true, true, today, "customer"));
		when(service.getCustomerUpdatedByDate()).thenReturn(reportList);
		List<GenerateReportModel> finallist=(List<GenerateReportModel>)controller.getCustomerUpdatedByDate().getBody();
		assertEquals(1, finallist.size());
		verify(service,times(1)).getCustomerUpdatedByDate();
	}
	
	@Test
	public void testGetCustomerUpdateByDateException() throws InterruptedException {
			
		Exception exception = assertThrows(NullPointerException.class, () -> {
			when(service.getCustomerUpdatedByDate()).thenThrow(NullPointerException.class);
			controller.getCustomerUpdatedByDate();
		});

		assertNotNull(exception);
		verify(service, times(1)).getCustomerUpdatedByDate();
	}
	
}
