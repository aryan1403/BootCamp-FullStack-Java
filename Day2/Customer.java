class Customer{

	private String name;
	private Boolean member = false;
	private String memberType;

	public Customer()
	{
		public String getName(){
		return name;
	}

   		 public boolean isMember() {
       	 return member;
  	  }

    		public void setMember(boolean member) {
        	this.member = member;
    }

    		public void setMemberType(String type) {
        	this.memberType = type;
    }

		public String toString() {
       	 if (member) {
          	  return "Customer " + name + " is a member of type " + memberType;
      	  } else {
         	   return "Customer " + name + " is not a member";
      	  }