package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.postAdd;
import ConnectionDB.postAddDAO;

@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		postAdd add = null;
		postAddDAO postDao = new postAddDAO();

		String post = request.getParameter("post");
		String tag = request.getParameter("tag");

		if (post != null ) {
			if (!post.isEmpty()) {
				if (postAddDAO.isRunning) {
					add = new postAdd();
					add.setPost(post);
					add.setTag(tag);
					postDao.save(add);
					postAddDAO.isRunning = false;
					list(request, response);

					// doPost(request, response);

				} else {
					list(request, response);
				}
			} else {
				System.out.println("Try again!");
				list(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		postAddDAO pAddDAO = new postAddDAO();

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "DELETE": {

			String addPost_id = request.getParameter("addPost_id");
			pAddDAO.delete(Integer.parseInt(addPost_id));
			list(request, response);

			break;
		}
		default:
			list(request, response);
		}

	}

//	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		postAddDAO pAddDAO = new postAddDAO();
//		String addPost_id = request.getParameter("addPost_id");
//		pAddDAO.delete(Integer.parseInt(addPost_id));
//		ArrayList<postAdd> posList = pAddDAO.list();
//
//		request.setAttribute("postList", posList);
//		request.getRequestDispatcher("MediaPageCopy.jsp").forward(request, response);
//
//	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		postAddDAO pAddDAO = new postAddDAO();

		ArrayList<postAdd> posList = pAddDAO.list();

		request.setAttribute("postList", posList);

		request.getRequestDispatcher("MediaPageCopy.jsp").forward(request, response);

	}

}
