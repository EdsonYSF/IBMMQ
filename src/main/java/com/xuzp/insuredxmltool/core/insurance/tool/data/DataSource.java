package com.xuzp.insuredxmltool.core.insurance.tool.data;


import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;

import java.io.Serializable;

public interface DataSource extends Serializable
{
	public DataRecord search(Factors param, String groupName);
	
	public String[] getGroupsName();
}
