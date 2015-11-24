package com.wxsafe.back.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wxsafe.ccy.action.AdminBase;
import com.wxsafe.ccy.dao.DataAccessObject;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.sql.CommonSql;

/**
 * @author : CaoChenYin
 * 
 * @Class : ContentAction
 * 
 * @description : 处理dtree.jsp页面导航栏显示分类请求
 * 
 * @date : 2009/04/10
 */
public class ContentAction extends AdminBase {

	public ActionForward doexecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			UserDto dto) {
		String flag = "fail";
		Connection conn = null;
		try {
			// 获得数据库连接
			conn = DataSourseFactory.getDataSource().getConnection();
			DataAccessObject dao = new DataAccessObject(conn);
			// 获取所有分类信息,并保存在list中
			List<Map<String, Object>> list = dao.executeQuery(CommonSql
					.listNodeSql());
			conn.close();

			String[] node = new String[list.size()];
			Iterator<Map<String, Object>> ir = list.iterator();
			int i = 0;
			// 遍历所有分类,进行处理
			while (ir.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) ir.next();

				String nodeID = map.get("nodeID").toString();
				String nodeName = map.get("nodeName").toString();
				String nodeParent = map.get("nodeParent").toString();
				int nodeType = Integer.parseInt(map.get("nodeType").toString());
				// 生成dtree使用语句保存在node字符串数组中
				StringBuffer bf = new StringBuffer();
				bf.append("d.add(");
				if (0 == nodeType) {
					bf.append(nodeID);
					bf.append("," + nodeParent);
					bf.append(",'" + nodeName + "','");
					bf.append("viewType.do?typeID=" + nodeID);
					bf.append("','','right','','','',0);");

				}
				node[i] = bf.toString();
				i++;
			}
			//将node字符串数组传回页面
			request.setAttribute("node", node);
			flag = "success";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapping.findForward(flag);
	}
}