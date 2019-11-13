package cn.edu.seu.wh.seckill;

import cn.edu.seu.wh.seckill.entity.Seckill;
import cn.edu.seu.wh.seckill.mapper.SeckillMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeckillApplicationTests {

	@Autowired
	private SeckillMapper seckillMapper;

	@org.junit.Test
	public void findAll() {
		List<Seckill> all = seckillMapper.findAll();
		for (Seckill seckill : all) {
			System.out.println(seckill.getTitle());
		}
	}

	@org.junit.Test
	public void findById() {
		Seckill seckill = seckillMapper.findById(1l);
		System.out.println(seckill.getTitle());
	}

	@Test
	public void reduceStock() {
		int row = seckillMapper.reduceStock(1l, new Date());
		System.out.println(row);
	}

}
