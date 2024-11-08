package Service;

import javax.servlet.http.HttpSession;

public class User10086Service {

    // 假设我们有一个User类，它包含用户的属性（如用户名、密码等）  
    public static class User {
        private String account;
        // 还可以有其他属性，如密码、电子邮件等  

        public User(String account) {
            this.account = account;
        }

        public String getAccount() {
            return account;
        }

        // 还可以有其他getter和setter方法  
    }

    // 模拟用户登录的方法，实际中您可能需要在数据库中验证用户凭据  
    public User login(String account, String password) {
        // 这里只是简单模拟，真实场景中需要查询数据库验证用户名和密码  
        if ("admin".equals(account) && "password".equals(password)) {
            return new User(account); // 假设验证成功，返回用户对象
        }
        return null; // 验证失败，返回null  
    }

    // 检查用户是否已登录的方法  
    public boolean isUserLoggedIn(HttpSession session) {
        // 假设我们在会话中存储了用户对象，键名为"loggedInUser"  
        return session.getAttribute("loggedInUser") != null;
    }

    // 获取当前登录用户的方法  
    public User getCurrentUser(HttpSession session) {
        // 从会话中获取用户对象  
        return (User) session.getAttribute("loggedInUser");
    }

    // 用户登出的方法（通常在一个Servlet或控制器中调用）  
    public void logout(HttpSession session) {
        // 从会话中移除用户对象  
        session.removeAttribute("loggedInUser");
    }
}