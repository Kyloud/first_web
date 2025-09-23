package com.example.demo.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.employees.DepartmentsDAO;
import com.example.demo.dto.Departments;

@Service
public class DepartmentsService
{
	private final DepartmentsDAO departmentsDAO;
	
	public DepartmentsService(DepartmentsDAO departmentsDAO)
	{
		this.departmentsDAO = departmentsDAO;		
	}
	
	public List<Departments> getAllDepartments()
	{
		return departmentsDAO.getAllDepartments();
	}
	
	// @Transactional은 작업이 성공적으로 완료되면 커밋함, 망하(예외)면 롤백 함
	@Transactional(transactionManager = "employeesDBTransactionManager")
	public int insertDepartment(String dept_no, String dept_name)
	{
		// 예를 들어...
		// 1. 내통장에서 송금할 금액 차감
		// 2. 내 통장에 송금된 금액 추가
		// 3. 상대방 통장에 송금된 금액 추가
		// 4. 상대방 통장에 송금 이력 추가
		
		// 예외가 발생하지 않아도 rollback 하고 싶다면
		// 해당 조건을 분기문을 나누어 예외를 발생시켠 됨
		// ex) throws Exception
		
		int result = departmentsDAO.insertDepartment(dept_no, dept_name);
		
		if(result > 0);
		{
			try { udpSocketTest(dept_no); }
			catch (IOException e)
			{
				e.printStackTrace();
				result = -1;
			}
		}
		
		return result;
	}
	
	
	public boolean udpSocketTest(String dept_no) throws IOException
	{
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("192.168.1.39");
		
		byte[] buffer = dept_no.getBytes();
		
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5050);

		clientSocket.send(packet);
		
		clientSocket.close();
		
		return false;
	}
	
}
