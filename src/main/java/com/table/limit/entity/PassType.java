package com.table.limit.entity;

public enum PassType {
	RED(5,30, 1), GREEN(3, 30,2);
	  // 成员变量
    private int count;
    private int time;
    private int index;
    
    /**
     * 获取最大错误次数
     * @param index
     * @return
     * @author gbq
     * 2016年4月24日
     */
    public static int getCount(int index) {
        for (PassType passType : PassType.values()) {
            if (passType.getIndex() == index) {
                return passType.count;
            }
        }
        return 0;
    }

    /**
     * 获取失效间隔
     * @param index
     * @return
     * @author gbq
     * 2016年4月24日
     */
    public static int getTime(int index) {
        for (PassType passType : PassType.values()) {
            if (passType.getIndex() == index) {
                return passType.time;
            }
        }
        return 0;
    }
    
    private PassType(int count,int time,int index) {
		this.index = index;
		this.count = count;
		this.time = time;
	}
    
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
