package polymorphism;

public class BeanFactory {
	// 디자인패턴이용해서 결합도 낮추기 -> 팩토리패턴!
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
