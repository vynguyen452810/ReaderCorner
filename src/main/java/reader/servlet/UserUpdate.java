package reader.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reader.dal.UsersDao;
import reader.model.Users;


@WebServlet("/userupdate")
public class UserUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected UsersDao usersDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = UsersDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        System.out.print("userUpdate");
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userName = req.getParameter("username");
        
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Users user = usersDao.getUserByUserName(userName);
        		if(user == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("user", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userName = req.getParameter("username");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Users user = usersDao.getUserByUserName(userName);
        		if(user == null) {
        			messages.put("success", "UserName does not exist. No update to perform.");
        		} else {
        			String newPassword = req.getParameter("password");
        			if (newPassword == null || newPassword.trim().isEmpty()) {
        	            messages.put("failed", "Please enter a valid password.");
        			} else {
        				user = usersDao.updatePassword(user, newPassword);
        	        	messages.put("success", "Successfully updated " + userName);
        			}
        		}
        		req.setAttribute("User", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
     
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
    }
}


