package cn.ustb.dbc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateSessionFactory {
	// 表示提供有ThreadLocal对象保存，适合于进行线程的准确处理
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static org.hibernate.SessionFactory sessionFactory; // 连接工厂
	
    private static Configuration configuration = new Configuration(); // 读取配置文件
    private static ServiceRegistry serviceRegistry;  // 服务注册类

	static { // 静态代码块，可以在类加载的时候执行一次
    	try {
			configuration.configure(); // 读取配置文件
			serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			try {
				// 在静态块中就已经准备好了SessionFactory类的对象
				sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
    private HibernateSessionFactory() { // 构造方法被私有化，应为本类不需要提供构造
    }
	
    /**
     * 取得Session对象，对象是通过ThreadLocal类取得的，如果没有保存的Session，那么会重新连接
     * @return Session操作对象
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
    	// 为了防止用户可能重复的使用Session对象，是通过保存在ThreadLocal类中的Session直接使用的
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) { // 如果第一次使用，或者之前关闭了，那么Session为空
			if (sessionFactory == null) { // 判断此时是否存在有SessionFactory类对象
				rebuildSessionFactory(); // 如果SessionFactory不存在，则重新创建一个SessionFactory
			}
			// 判断此时是否取得了SessionFactory类对象，如果取得，则使用openSession()打开新Session，
			// 否则返回null
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session); // 为了防止可能重复使用Session，将其保存在ThreadLocal
		}

        return session;
    }

	/**
	 * 重新进行SessionFactory类对象的创建
	 */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
	 * 所有操作的最后一定要关闭Session，在业务层中关闭
	 * @throws HibernateException
	 */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get(); // 取得已有的Session
        threadLocal.set(null); // 清空ThreadLocal的保存

        if (session != null) { // 将Session进行关闭
            session.close();
        }
    }

	/**
	 * 取得SessionFactory类的对象
	 * @return
	 */
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * 取得Configuration类的对象
	 * @return
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}

}