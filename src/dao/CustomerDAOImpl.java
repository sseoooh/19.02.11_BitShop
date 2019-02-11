package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	CustomerDAOImpl dao;
	private CustomerDAOImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerDAOImpl getInstance() {return instance;}


	@Override
	public void insertCustomer(CustomerDTO cus) {
		
		try {
		System.out.println("CustomerDB입장");
		String sql = CustomerSQL.SIGNUP.toString();
		System.out.println("실행할쿼리"+sql);
		Connection conn =
				DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cus.getCustomerID());
		pstmt.setString(2, cus.getCustomerName());
		pstmt.setString(3, cus.getPassword());
		pstmt.setString(4, cus.getAddress());
		pstmt.setString(5, cus.getCity());
		pstmt.setString(6, cus.getPostalcode());
		pstmt.setString(7, cus.getSsn());
		int rs = pstmt.executeUpdate();
		System.out.println((rs==1) ? "입력성공":"입력실패");
				
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

	@Override
	public List<CustomerDTO> selectCustomerList() {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = CustomerSQL.LIST.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			CustomerDTO cus = null;			
			while(rs.next()) {
				cus = new CustomerDTO();				
				cus.setCustomerID(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setSsn(rs.getString("SSN"));
				cus.setPhone(rs.getString("PHONE"));
				cus.setCity(rs.getString("CITY"));
				cus.setAddress(rs.getString("ADDRESS"));
				cus.setPostalcode(rs.getString("POSTALCODE"));
				cus.setPhone(rs.getString("PHOTO"));
				
				list.add(cus);
			}			
			System.out.println("1번회원"+list.get(0).getCustomerName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String SearchWord) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO cdto = null;
		try {
			
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cdto = new CustomerDTO();
				cdto.setAddress(rs.getString("ADDRESS"));
				cdto.setCity(rs.getString("CITY"));
				cdto.setCustomerID(rs.getString("CUSTOMER_ID"));
				cdto.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cdto.setPassword(rs.getString("PASSWORD"));
				cdto.setPostalcode(rs.getString("POSTALCODE"));
				cdto.setSsn(rs.getString("SSN"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public int countCustomer() {
		int count = 0;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		boolean b = false;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	@Override
	public void updateCustomer(CustomerDTO emp) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO emp) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
			if(rs==1) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
