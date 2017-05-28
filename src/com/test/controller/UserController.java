package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.UserDao;
import com.test.entity.AlamatUser;
import com.test.entity.User;

/**
 * Servlet implementation class UserControllerr
 */
@WebServlet("/UserControllerr")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String list = "/list.jsp";
	private static String add = "/add.jsp";
	private static String emptyList = "/list_kosong.jsp";
	private UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        dao = new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = null;
		String action = request.getParameter("action");
		
		if (action.equals("list")) {
			List<User> lists = dao.getAllUser();
			if (lists.isEmpty()) {
				forward = emptyList;
			} else if (!lists.isEmpty()) {
				forward = list;
			}
			request.setAttribute("users", lists);
		} else if (action.equals("add")) {
			forward = add;
		} else if (action.equals("search")) {
			String nama = request.getParameter("nama");
			List<User> lists = dao.searchUser(nama);
			forward = list;
			request.setAttribute("users", lists);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setNama(request.getParameter("nama"));
		user.setNoHp(request.getParameter("noHp"));
		user.setEmail(request.getParameter("email"));
		
		int idUser = dao.add(user);
		AlamatUser alamatUser = new AlamatUser();
		alamatUser.setIdUser(idUser);
		
		String alamat = "alamat";
		
		for (int i = 1; i > 0; i++) {
			String x = request.getParameter(alamat+i);
			if (x == null) {
				break;
			} else {
				alamatUser.setAlamat(x);
				dao.tambahAlamat(alamatUser);
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(list);
        request.setAttribute("users", dao.getAllUser());
        view.forward(request, response);
		// TODO Auto-generated method stub
	}
	
	

}
