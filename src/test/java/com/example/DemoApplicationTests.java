package com.example;

import com.example.dao.TestMongodb;
import com.example.model.JsonBean;
import com.example.model.bean.*;
import com.example.service.UserService;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserService userSerivce;

	@Autowired
	private TestMongodb testMongodb;

	@Before
	public void setUp() {
		// 准备，清空user表
		userSerivce.deleteAllUsers();
	}

	/**
	 * 测试自动化配置
	 */
	@Test
	public void testDemo(){

		JsonBean jsonBean = new JsonBean();

		//设置主bean
		jsonBean.setHost("172.16.1.207");
		jsonBean.setTitle("进件系统");
		jsonBean.setBaseUrl("/zy-apply");

		ParamsBean paramsBean = new ParamsBean();

		paramsBean.setProperty(setProperty());
		paramsBean.setCarInfo(setCarInfo());
		jsonBean.setParams(paramsBean);

		testMongodb.save(jsonBean);
	}


	/**
	 * 设置车辆信息
	 * @return
	 */
	private CarInfoBean setCarInfo(){

		CarInfoBean carInfoBean = new CarInfoBean();
		carInfoBean.setIndex(1);
		carInfoBean.setModuleName("车辆信息");

		List<DescriptionBean> descriptionBeanList = Lists.newArrayList();

		for(int i = 0; i < 10; i++){
			DescriptionBean descriptionBean = new DescriptionBean();
			descriptionBean.setType("text");
			descriptionBean.setLabel("姓名");
			descriptionBean.setSubmit("name");
			descriptionBean.setProp("name");
			descriptionBean.setIsRequire("True");
			descriptionBean.setPlaceholder("请输入姓名");
			descriptionBean.setCol("1");
			descriptionBean.setOptions(Lists.newArrayList());
			//
			RulesBean rulesBean = new RulesBean();
//			rulesBean.setMaxLength();
			descriptionBean.setRules(rulesBean);
			descriptionBeanList.add(descriptionBean);
		}

		carInfoBean.setDescription(descriptionBeanList);

		return carInfoBean;
	}
	/**
	 * 设置属性
	 * @return
	 */
	private PropertyBean setProperty(){

		PropertyBean propertyBean = new PropertyBean();
		propertyBean.setIndex(2);
		propertyBean.setModuleName("房产信息");
        return propertyBean;
	}


	@Test
	public void test() {
		// 插入5个用户
		userSerivce.create("a", 1);
		userSerivce.create("b", 2);
		userSerivce.create("c", 3);
		userSerivce.create("d", 4);
		userSerivce.create("e", 5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 删除两个用户
		userSerivce.deleteByName("a");
		userSerivce.deleteByName("e");

		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

	}
}
