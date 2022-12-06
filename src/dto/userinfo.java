package dto;

import java.util.Objects;

public class userinfo {
   private String username;
   private String Password;

   @Override
public int hashCode() {
	return Objects.hash(Password, username);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	userinfo other = (userinfo) obj;
	return Objects.equals(Password, other.Password) && Objects.equals(username, other.username);
}
public userinfo(String userName, String password) {
	super();
	this.username = userName;
	Password = password;
}
public userinfo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "user [userName=" + username + ", Password=" + Password + "]";
}
public String getUserName() {
	return username;
}
public void setUserName(String userName) {
	this.username = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
}
