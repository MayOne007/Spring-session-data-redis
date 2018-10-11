package core.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/*@Component*/
public class SessionRepositoryRequestWrapper extends HttpServletRequestWrapper {

	public SessionRepositoryRequestWrapper(HttpServletRequest original) {
		super(original);
	}
	@Override
	public HttpSession getSession() {
		return getSession(false);
	}
	/*@Override
	public HttpSession getSession(boolean createNew) {
		return null;
		// create an HttpSession implementation from Spring Session
	}*/

	// ... other methods delegate to the original HttpServletRequest ...
}
