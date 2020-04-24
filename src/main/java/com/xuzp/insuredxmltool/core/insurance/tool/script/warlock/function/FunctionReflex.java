package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class FunctionReflex implements Function
{
	@Override
	public Object run(Object[] vv, Factors p)
	{
		Object value;

		Object v = vv[0];
		String name = vv[1].toString();
		Object[] wrap = (Object[])vv[2];

		Class[] classArray = new Class[wrap.length];
		for (int i=0;i<classArray.length;i++)
		{
			if (wrap[i] != null)
				classArray[i] = wrap[i].getClass();
		}

		Method method = null;
		try
		{
			method = v.getClass().getDeclaredMethod(name, classArray);
		}
		catch (NoSuchMethodException e)
		{
			//����ķ������������ĳ�������Ǵ�������ĸ��࣬����Ҳ����÷�������������������һ�´���
			//OC--
			Method[] m = v.getClass().getMethods();
			for (int i=0;i<m.length;i++)
			{
				if (name.equals(m[i].getName()))
				{
					Class[] c = m[i].getParameterTypes();
					if (c.length == classArray.length)
					{
						boolean pass = true;
						for(int j=0;j<c.length;j++)
						{
							//���������null������int(double boolean���Ȳ�������)������������ʺϣ�ֻ�ҵ�һ����
							if (wrap[j] == null && !c[j].equals(Integer.TYPE))
							{
							}
							//int
							else if (c[j].equals(Integer.TYPE) && wrap[j] instanceof Integer)
							{
							}
							else if (c[j].equals(Integer.TYPE) && wrap[j] instanceof BigDecimal)
							{
								wrap[j] = Integer.valueOf(((BigDecimal)wrap[j]).intValue());
							}
							//boolean
							else if (c[j].equals(Boolean.TYPE) && wrap[j] instanceof Boolean)
							{
							}
							//double
							else if (c[j].equals(Double.TYPE) && wrap[j] instanceof Double)
							{
							}
							else if (c[j].equals(Double.TYPE) && wrap[j] instanceof Integer)
							{
								wrap[j] = Double.valueOf(((Integer)wrap[j]).doubleValue());
							}
							else if (c[j].equals(Double.TYPE) && wrap[j] instanceof Float)
							{
								wrap[j] = Double.valueOf(((Float)wrap[j]).doubleValue());
							}
							else if (c[j].equals(Double.TYPE) && wrap[j] instanceof BigDecimal)
							{
								wrap[j] = Double.valueOf(((BigDecimal)wrap[j]).doubleValue());
							}
							//float
							else if (c[j].equals(Float.TYPE) && wrap[j] instanceof Integer)
							{
								wrap[j] = Float.valueOf(((Integer)wrap[j]).floatValue());
							}
							else if (c[j].equals(Float.TYPE) && wrap[j] instanceof Float)
							{
							}
							else if (c[j].equals(Float.TYPE) && wrap[j] instanceof Double)
							{
								wrap[j] = Float.valueOf(((Float)wrap[j]).floatValue());
							}
							else if (c[j].equals(Float.TYPE) && wrap[j] instanceof BigDecimal)
							{
								wrap[j] = Float.valueOf(((BigDecimal)wrap[j]).floatValue());
							}
							else if (!c[j].isInstance(wrap[j]))
							{
								pass = false;
								break;
							}
						}

						if (pass)
						{
							method = m[i];
							break;
						}
					}

				}
			}
			//--OC
		}

		try
		{
			if (method == null)
				throw new NoSuchMethodException();

			value = method.invoke(v, wrap);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException("point����ȡֵʧ�ܣ�û�и÷��� -- ����" + v + "��������: " + name + "<" + wrap.length + ">", e);
		}
		catch (Exception e)
		{
			throw new RuntimeException("point����ȡֵʧ�ܣ������ڲ����� -- ����" + v + "��������: " + name, e);
		}

		return value;
	}
}
