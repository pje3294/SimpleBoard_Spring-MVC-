package controller.action;

public class ActionForward {

	// "페이지전달방식"과 "경로"를 매개변수로 하는 객체 

	private boolean redirect;
	private String path;

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ActionForward [redirect=" + redirect + ", path=" + path + "]";
	}

}
