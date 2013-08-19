package com.jeefuse.system.security.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.exception.InvalidDataException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.condition.order.OrderMode;
import com.jeefuse.base.modules.condition.order.OrderSet;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.utils.tree.TreeLayerCodeUtil;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
import com.jeefuse.system.security.service.GsysFunctionService;
import com.jeefuse.system.security.web.rto.GsysFunctionRTO;

/**
 * GsysFunction Entity CRUD service impl.
 * 
 * @author yonclv
 * @generated
 */
@Service(value = "gsysFunctionServiceImpl")
public class GsysFunctionServiceImpl extends GenericServiceImpl<GsysFunction, String> implements GsysFunctionService {
	private final static int LAYER_LEN = TreeLayerCodeUtil.defaultLayerLen;
	private final static int LAYER_MAX_DEEP = TreeLayerCodeUtil.defaultLayerMaxDeep;
	public static final String SERVICE_ID = "gsysFunctionServiceImpl";

	/**
	 * GsysFunctionServiceImpl constructor with set GsysFunction entity Class.
	 * 
	 * @generated
	 */
	@Autowired
	public GsysFunctionServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysFunction.class);
	}

	@Override
	public void save(GsysFunction newModel) {
		if (StringUtils.isNotBlank(newModel.getParentId())) {
			GsysFunction parent = get(newModel.getParentId());
			if (null == parent)
				throw new DataNoExistException("上级节点不存在!");
			String nextLayerCode = getNextLayerCode(newModel.getParentId());
			newModel.setLayerCode(nextLayerCode);
			// 注意:hibernate会管理会话中的状态,如果先设置父节点,将会认为数据库中以存在该状态,设置layerCode时将不正确
			newModel.setParent(parent);
		} else {
			String nextLayerCode = getNextLayerCode(null);
			newModel.setLayerCode(nextLayerCode);
		}
		hibernateDao.save(newModel);
	}

	/*
	 * 保存对象,添加树形layerCode支持.
	 */
	@Transactional
	public GsysFunction save(GsysFunctionRTO rto) {
		GsysFunction newModel = rto.getNewModel();
		if (StringUtils.isNotBlank(newModel.getParentId())) {
			GsysFunction parent = get(newModel.getParentId());
			if (null == parent)
				throw new DataNoExistException("上级节点不存在!");
			String nextLayerCode = getNextLayerCode(newModel.getParentId());
			newModel.setLayerCode(nextLayerCode);
			// 注意:hibernate会管理会话中的状态,如果先设置父节点,将会认为数据库中以存在该状态,设置layerCode时将不正确
			newModel.setParent(parent);
		} else {
			String nextLayerCode = getNextLayerCode(null);
			newModel.setLayerCode(nextLayerCode);
		}
		hibernateDao.save(newModel);
		return newModel;
	}

	/*
	 * 更新对象,添加树形layerCode.
	 */
	@Transactional
	public GsysFunction update(GsysFunctionRTO rto, boolean isvalidate) {
		GsysFunction oldModel = get(rto.getId());
		Assert.notNull(oldModel, "您更新的对象不存在!");
		GsysFunction parent = null;
		if (StringUtils.isNotBlank(rto.getParentId())) {
			parent = get(rto.getParentId());
			if (null == parent)
				throw new DataNoExistException("上级节点不存在!");
		}
		String oldParendId = oldModel.getParentId();
		String oldLayerCode = oldModel.getLayerCode();
		GsysFunction newModel = null;
		// 未设置上级节点
		if (null == oldParendId && rto.getParentId() == null) {
			newModel = rto.getModifiedModel(oldModel);
		}
		// 上级节相同时
		else if (null != oldParendId && oldParendId.equals(rto.getParentId())) {
			newModel = rto.getModifiedModel(oldModel);
		}
		// 上级节点变更时,同时更改层次节点
		else {
			// 获取当前层次代码
			String newLayerCode = getNextLayerCode(rto.getParentId());
			// 重新设置子对象的层次代码
			updateDescendant(oldLayerCode, newLayerCode, false);
			newModel = rto.getModifiedModel(oldModel);
			newModel.setLayerCode(newLayerCode);
		}
		newModel.setParent(parent);
		// 注意:hibernate会管理会话中的状态,如果先设置父节点,将会认为数据库中以存在该状态,设置layerCode时将不正确
		//		if (isvalidate) {
		//			GsysFunctionValidate.validateWithException(newModel);
		//		}
		// hibernateDao.update(newModel);//in session hibernate will auto update it.
		return newModel;
	}

	@Override
	public List<GsysFunction> getAll(Order... orders) {
		return super.getAll(buildOrderSet(orders).toOrderArray());
	}

	private OrderSet buildOrderSet(Order... orders) {
		OrderSet orderSet = null;
		if (null == orders || orders.length == 0) {
			orderSet = OrderSet.create();
			orderSet.addOrder(GsysFunctionField.layerCode.getFieldName(), OrderMode.ASC);
			orderSet.addOrder(GsysFunctionField.sortNum.getFieldName(), OrderMode.ASC);
		} else {
			orderSet = OrderSet.create(orders);
		}
		return orderSet;
	}

	/** @generated */
	public List<GsysFunction> findByProperty(GsysFunctionField gsysFunctionField, Object value) {
		return findByProperty(gsysFunctionField.getFieldName(), value);
	}

	/** @generated */
	public boolean isPropertyUnique(GsysFunctionField gsysFunctionField, Object newValue) {
		Object m = findUniqueByProperty(gsysFunctionField.getFieldName(), newValue);
		return (m == null);
	}

	/** @generated */
	public Page<GsysFunction> find(Page<GsysFunction> page, GsysFunctionRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysFunctionField.name.getFieldName(), rto.getName());
		if (StringUtils.isNotBlank(rto.getParentId())) {
			GsysFunction model = get(rto.getParentId());
			if (null != model) {
				condition.addStartsLike(GsysFunctionField.layerCode.getFieldName(), model.getLayerCode());
			}
		}
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/** @generated */
	@Transactional
	public ResultMsg<GsysFunction> importDatas(List<GsysFunction> importList) {
		ResultMsg<GsysFunction> result = new ResultMsg<GsysFunction>();
		if (null == importList || importList.isEmpty()) {
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysFunction> addList = new ArrayList<GsysFunction>();
		List<GsysFunction> updateList = new ArrayList<GsysFunction>();
		List<GsysFunction> noExistList = new ArrayList<GsysFunction>();
		for (GsysFunction gsysFunction : importList) {
			if (StringUtils.isBlank(gsysFunction.getId())) {
				gsysFunction.setId(null);
				addList.add(gsysFunction);
			} else {
				GsysFunction existModel = hibernateDao.get(entityClass, gsysFunction.getId());
				if (null == existModel) {
					noExistList.add(gsysFunction);
				} else {
					updateList.add(gsysFunction);
				}
			}
		}
		// 新增数据
		hibernateDao.save(addList);
		hibernateDao.update(updateList);
		int addCount = addList.size();
		int updateCount = updateList.size();
		int existCount = noExistList.size();
		StringBuilder msgSb = new StringBuilder("");
		msgSb.append("共找到" + importList.size() + "项记录!其中：<br>");
		if (addCount != 0) {
			msgSb.append("	成功新增:" + addCount + "项.<br>");
		}
		if (updateCount != 0) {
			msgSb.append("	成功更新:" + updateCount + "项.<br>");
		}
		if (existCount > 0) {
			msgSb.append("	更新失败" + existCount + "项,原因以下记录不存在:<br>");
			for (Iterator<GsysFunction> it = noExistList.iterator(); it.hasNext();) {
				GsysFunction model = it.next();
				msgSb.append(model.getId());
				if (it.hasNext()) {
					msgSb.append(", ");
				}
			}
		}
		result.setMessage(msgSb.toString());
		return result;
	}

	/*****************************************************************
	 * 树形操作
	/*****************************************************************/

	/**
	 * 根据层次代码获取所有后代对象,
	 * 
	 * @param layerCode
	 *            层次代码
	 * @param includeCurrent
	 *            是否包含当前层次代码的对象
	 */
	@SuppressWarnings("unchecked")
	public List<GsysFunction> findDescendantByLayerCode(String layerCode, boolean includeCurrent) {
		if (includeCurrent) {
			final String hql = "from GsysFunction m where  m.layerCode like ?";
			return hibernateDao.find(hql, layerCode + "%");
		} else {
			final String hql = "from GsysFunction m where  m.layerCode like ? and m.layerCode!=?";
			return hibernateDao.find(hql, layerCode + "%", layerCode);
		}
	}

	/**
	 * 根据层次代码获取所有后代对象,
	 */
	public Page<GsysFunction> findDescendant(Page<GsysFunction> page, GsysFunctionRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		if (null != rto) {
			condition.addStartsLikeIfNotBlank(GsysFunctionField.name.getFieldName(), rto.getName());
			if (StringUtils.isNotBlank(rto.getParentId())) {
				GsysFunction model = get(rto.getParentId());
				if (null != model) {
					condition.addStartsLike(GsysFunctionField.layerCode.getFieldName(), model.getLayerCode());
				}
			}
		}
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/**
	 * 获取层次代码.
	 * 
	 * @param parentId
	 *            上级ID
	 */
	private String getNextLayerCode(String parentId) throws DataNoExistException {
		String maxLayerCode = null;
		if (StringUtils.isNotBlank(parentId)) {
			// 有上级节点
			final String hql = "select m.layerCode from GsysFunction m where m.id=?";
			String parentLayerCode = (String) hibernateDao.findUnique(hql, parentId);
			if (null == parentLayerCode)
				throw new DataNoExistException("上级不存在或其层次代码为空!");
			if ((parentLayerCode.length() / LAYER_LEN + 1) > LAYER_MAX_DEEP)
				throw new InvalidDataException("最大不能超过"+LAYER_MAX_DEEP+"级层次!");
			if (!TreeLayerCodeUtil.isValideLayerCode(parentLayerCode, LAYER_LEN))
				throw new InvalidDataException("上级层次代码错误!请删除上级节点!");
			final String maxChildrenLayerhql = "select max(layerCode) from GsysFunction m where m.parent.id=?";
			maxLayerCode = (String) hibernateDao.findUnique(maxChildrenLayerhql, parentId);
			if (null == maxLayerCode)
				return parentLayerCode + TreeLayerCodeUtil.getNextLayerCode(maxLayerCode, LAYER_LEN);
			return TreeLayerCodeUtil.getNextLayerCode(maxLayerCode, LAYER_LEN);
		} else {
			// 没有上级节点
			final String maxChildrenLayerhql = "select max(layerCode) from GsysFunction m where m.parent is null";
			maxLayerCode = (String) hibernateDao.findUnique(maxChildrenLayerhql);
			return TreeLayerCodeUtil.getNextLayerCode(maxLayerCode, LAYER_LEN);
		}
	}

	/**
	 * 更新层次代码.
	 * 
	 * @param oldLayerCode
	 *            更新前的层次代码
	 * @param newLayerCode
	 *            更新后的层次代码
	 * @param includeCurrent
	 *            是否包含当前层次代码的对象
	 */
	@Transactional
	private void updateDescendant(String oldLayerCode, String newLayerCode, boolean includeCurrent) {
		List<GsysFunction> updateList = findDescendantByLayerCode(oldLayerCode, false);
		if (null != updateList && !updateList.isEmpty()) {
			for (GsysFunction gsysFunction : updateList) {
				String curLayerCode = gsysFunction.getLayerCode();
				String replaceLayerCode = newLayerCode == null ? "" : newLayerCode;
				gsysFunction.setLayerCode(curLayerCode.replaceFirst(oldLayerCode, replaceLayerCode));
				if (StringUtils.isBlank(newLayerCode)) {
					gsysFunction.setParent(null);
				}
			}
			// hibernateDao.update(updateList);in session don't need update
		}
	}

	public boolean hasChildren(String[] ids) {
		for (String id : ids) {
			Condition condition = Condition.and();
			condition.addEqIfNotBlank(GsysFunctionField.parentId.getFieldName(), id);
			long count = hibernateDao.countFind(entityClass, condition);
			if (count > 0)
				return true;
		}
		return false;
	}

	@Transactional
	public int deleteDescendant(String[] ids) {
		int count = 0;
		for (String id : ids) {
			GsysFunction model = get(id);
			List<GsysFunction> descendantList = findDescendantByLayerCode(model.getLayerCode(), true);
			hibernateDao.delete(descendantList);
			count += descendantList.size();
			// 批量删除
//			final String hql = "delete from GsysFunction m where  m.layerCode like ?";
//			count += hibernateDao.executeUpdate(hql, model.getLayerCode() + "%");
		}
		return count;
	}

	@Transactional
	@Override
	public int delete(String... ids) {
		int count = 0;
		for (String id : ids) {
			GsysFunction model = get(id);
			updateDescendant(model.getLayerCode(), null, false);
			hibernateDao.delete(model);
			count++;
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<TreeViewItem> getAllForTreeview(OrderSet orderSet) {
		final String hql = "select new GsysFunction(m.id,m.name,m.parent.id) from GsysFunction m";
		StringBuilder selectHqlsb = new StringBuilder(hql);
		if (null != orderSet) {
			selectHqlsb.append(orderSet.toOrderBySql());
		} else {
			selectHqlsb.append(buildOrderSet().toOrderBySql());
		}
		return hibernateDao.createQuery(selectHqlsb.toString()).list();
	}

	@SuppressWarnings("unchecked")
	public List<GsysFunction> getAllForTreeMenu() {
		final String hql = "select new GsysFunction(m.id,m.name,m.parent.id,m.url) from GsysFunction m";
		StringBuilder selectHqlsb = new StringBuilder(hql);
		selectHqlsb.append(buildOrderSet().toOrderBySql());
		return hibernateDao.createQuery(selectHqlsb.toString()).list();
	}

}
