package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.DataInsentif.Insentif;
import com.Koneksi.Koneksi;

public class Manipulasi {

//=================================================================================================================
	//Membuat List ambildataInsentif
	public static List<Insentif> ambilDataInsentif(String namaGol, String nama) {
		List<Insentif> empList = new ArrayList<Insentif>();

		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM insentif WHERE nama_golongan='" + namaGol
				+ "'";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int gaji;
		float insentif;

		try {
			while (resultSet.next()) {
				Insentif emp1 = new Insentif();

				gaji = Integer.parseInt(resultSet.getString("gaji_golongan"));
				emp1.setGajiGolongan(gaji);

				insentif = Float.parseFloat(resultSet.getString("insentif"));
				emp1.setInsentif(insentif);
				emp1.setNamaGolongan(resultSet.getString("nama_golongan"));

				emp1.setInsentifGaji((int) (gaji * insentif));
				emp1.setNama(nama);

				empList.add(emp1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

//=================================================================================================================
	//ambildatainsentif
	public static float ambilDataInsentifBeta(String namaGol) {
		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM insentif as ins WHERE ins.nama_golongan='" + namaGol
				+ "'";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		float insentif = 0;

		try {
			while (resultSet.next()) {

				insentif = Float.parseFloat(resultSet.getString("insentif"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return insentif;
	}
	
//=================================================================================================================
	//simpan data karyawan
	public static void SimpanDataKaryawan(Insentif ambil){
		try
	    {
	      // create a mysql database connection
//		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//		  Date date = new Date();
	      
		  String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
	      // the mysql insert statement
	      /*String query = " insert into databarukaryawan (nama_karyawan,golongan_karyawan)"
	        + " values (?, ?)";*/
	      
	      String query = "INSERT INTO `karyawaninsentif`.`databarukaryawan` "
	      		+ "(`nama_karyawan`, `golongan_karyawan`, `foto_karyawan`) "
	      		+ "SELECT * FROM (SELECT ?, ?,(SELECT foto FROM karyawan WHERE nama_karyawan=?)) AS dat WHERE NOT EXISTS "
	      		+ "(SELECT nama_karyawan FROM databarukaryawan WHERE nama_karyawan = ?) "
	      		+ "LIMIT 1";
	      
	     
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      //indexdatabase from 1 to 4
	      preparedStmt.setString (1, ambil.getNama());
	      preparedStmt.setString (2, ambil.getNamaGolongan());
	      preparedStmt.setString (3, ambil.getNama());
	      preparedStmt.setString (4, ambil.getNama());
	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Masalah Data Karyawan");
	      System.err.println(e.getMessage());
	    }
	}

}
