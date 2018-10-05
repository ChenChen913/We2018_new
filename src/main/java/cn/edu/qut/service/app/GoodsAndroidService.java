package cn.edu.qut.service.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.AttributeDao;
import cn.edu.qut.dao.GoodsDao;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.app.GoodsAttr;

@Service
public class GoodsAndroidService {
	@Autowired
	GoodsDao goodsDao;
	@Autowired
	AttributeDao attrDao;
	
	public List<Goods> goodsList(Goods t){
		return goodsDao.list(t);
	}
	
	
	public List<GoodsAttr> goodsAttr(Goods t){
		List<Goods> goodsList = goodsDao.list(t);
		List<GoodsAttr> goodsAttr  = new ArrayList<GoodsAttr>();
		
		for(Goods goods: goodsList){
			GoodsAttr goodsAttribute = null;
			Attribute attr = new Attribute();
			attr.setGoods_id(goods.getGoods_id());
			List<Attribute> attrs = attrDao.list(attr);
			if(!attrs.isEmpty()){
				for(Attribute attrone : attrs){
					goodsAttribute = new GoodsAttr(goods,attrone);
					goodsAttr.add(goodsAttribute);
				}
			}else{
				goodsAttribute = new GoodsAttr(goods,new Attribute());
				goodsAttr.add(goodsAttribute);
			}
		}
		
		return goodsAttr;
	}
}
