package com.wisdom.life.supplier.web.filter;

public class AbstractExcludeUrlFilterTest {

	public static void main(String[] args) {
		String includes[] = "/*login.jhtml;/loginSubmit.jhtml".split(";");
		String path = "/fd/login.jhtml";
		for (int i = 0; i < includes.length; i++) {

			String regx = includes[i].trim().replaceAll("\\.", "\\\\.");
			regx = regx.replaceAll("\\*", "\\.*");
			if (includes[i].endsWith("/")) {
				regx += ".*";
			}
			if (path.matches(regx)) {
				System.out.println("ok");
				break;
			}
		}
	}

}
