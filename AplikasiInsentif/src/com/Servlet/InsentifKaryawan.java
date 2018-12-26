package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataInsentif.Insentif;
import com.Model.Manipulasi;

/**
 * Servlet implementation class InsentifKaryawan
 */
@WebServlet("/InsentifKaryawan")
public class InsentifKaryawan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsentifKaryawan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		// String name = (String) request.getAttribute("name");
		String namaGolongan = request.getParameter("namaGolongan");
		String nama = request.getParameter("nama");
		System.out.println(nama);

		// simpan data
		Insentif data = new Insentif();
		data.setNama(nama);
		data.setNamaGolongan(namaGolongan);

		// panggil fungsi simpandatakaryawandari Manipulasi.
		Manipulasi.SimpanDataKaryawan(data);

		// ambil data insentif
		Float ambilDataInsentifBeta = Manipulasi.ambilDataInsentifBeta(namaGolongan);

		pw.print(ambilDataInsentifBeta.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
