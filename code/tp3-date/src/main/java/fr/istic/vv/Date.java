package fr.istic.vv;

class Date implements Comparable<Date> {
	
	private int day;
	private int month;
	private int year;

    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }

    public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public static boolean isValidDate(int day, int month, int year) {
    	return 0<day && day<=31 && 0<month && month<=12 && year>=0;
    }

    public static boolean isLeapYear(int year) {
    	if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }else {
                	return false;
                }
            }
            return true;
        }
        return false;
    }

    public Date nextDate() {
    	int newDay = day;
    	int newMonth = month;
    	int newYear = year;
    	newDay++;
    	if(newDay>31) {
    		newDay = 1;
    		newMonth++;
    		if(newMonth>12) {
    			newMonth = 1;
    			newYear++;
    		}
    	}
    	return new Date(newDay, newMonth, newYear);
    }

    public Date previousDate() {
    	int newDay = day;
    	int newMonth = month;
    	int newYear = year;
    	newDay--;
    	if(newDay<1) {
    		newDay = 31;
    		newMonth--;
    		if(newMonth<1) {
    			newMonth = 12;
    			newYear--;
    		}
    	}
    	return new Date(newDay, newMonth, newYear);
    }

    public int compareTo(Date other) {
    	if(other.getYear() == year) {
    		if(other.getMonth() == month) {
    			return day - other.getDay();
    		}
    		return month - other.getMonth();
    	}
    	return year - other.getYear();
    }

}
