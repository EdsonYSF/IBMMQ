package com.xuzp.insuredxmltool.core.insurance.tool.formula;

public class FormulaException extends RuntimeException
{
	public FormulaException(String detail)
	{
		super(detail);
	}

	public FormulaException(String detail, Exception e)
	{
		super(detail, e);
	}
}
