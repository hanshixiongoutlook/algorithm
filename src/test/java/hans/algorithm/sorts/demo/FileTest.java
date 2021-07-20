package hans.algorithm.sorts.demo;

import org.junit.Test;

import java.io.File;

public class FileTest {

	class User {
		private String name;
		private Integer age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}

	private Integer age;
	@Test
	public void test1() {
		User u = new User();
		u.setName("A");

		change(u);
		sys(u);

		System.out.println(age);

	}

	private void sys(User u) {
		age = u.getAge();
	}
	private void change(User user) {
		user.setAge(100);
	}

	@Test
	public void test() {
		File path = new File("F:\\C\\D");

		int i=0;
		for (File f: path.listFiles()) {
			if (f.getAbsolutePath().endsWith("2015")) {
				continue;
			}
			for (File reF: f.listFiles()) {
				i++;
				String newFileName = "";
				if (reF.getName().startsWith("ok")) {
					newFileName = reF.getName().replace("ok", "ok."+"["+f.getName()+"]");
				} else if (reF.getName().startsWith("good")) {
					newFileName = reF.getName().replace("good", "good."+"["+f.getName()+"]");
				} else {
					newFileName = "["+f.getName()+"]"+reF.getName();
				}
				String newFile = f.getAbsolutePath()+File.separator+newFileName;

				System.out.println("old: "+reF.getAbsolutePath());
//				System.out.println("new: "+newFile);
				System.out.println("renameTo:"+newFile);
				reF.renameTo(new File(newFile));

			}
		}
		System.out.println("total="+i);
	}
}
