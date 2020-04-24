package com.xuzp.insuredxmltool.core.insurance.tool.data.source;

import com.xuzp.insuredxmltool.core.insurance.tool.data.DataNotFoundException;
import com.xuzp.insuredxmltool.core.insurance.tool.data.DataParser;
import com.xuzp.insuredxmltool.core.insurance.tool.data.DataRecord;
import com.xuzp.insuredxmltool.core.insurance.tool.data.DataSource;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;

import java.util.Map;

public class XmlDS implements DataParser, DataSource
{
	private static final long serialVersionUID = 1L;

	public XmlDS(Map param)
	{
	}
	
	public DataRecord search(Factors param, String groupName) throws DataNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getGroupsName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public DataSource newSource(Map param)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
