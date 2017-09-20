package com.group.isoft.bearsport.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseClientRespModel
{
    private String result = "";

    private List<String> errorCode = new ArrayList<String>();

    private Map<String, String> params = new HashMap<String, String>();
    
    private List<?> data;
    
    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public List<String> getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(List<String> errorCode)
    {
        this.errorCode = errorCode;
    }

    public Map<String, String> getParams()
    {
        return params;
    }

    public void setParams(Map<String, String> params)
    {
        this.params = params;
    }

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
