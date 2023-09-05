package test003.hanb.member;

public class Member {
	private String mId;
	private String mPw;
	private String mPhone;
	private String mMail;
	private String mRegDay;
	private String mModDay;

	public Member(String mId, String mPw, String mPhone, String mMail, String mRegDay, String mModDay) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mPhone = mPhone;
		this.mMail = mMail;
		this.mRegDay = mRegDay;
		this.mModDay = mModDay;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmMail() {
		return mMail;
	}

	public void setmMail(String mMail) {
		this.mMail = mMail;
	}

	public String getmRegDay() {
		return mRegDay;
	}

	public void setmRegDay(String mRegDay) {
		this.mRegDay = mRegDay;
	}

	public String getmModDay() {
		return mModDay;
	}

	public void setmModDay(String mModDay) {
		this.mModDay = mModDay;
	}

}
