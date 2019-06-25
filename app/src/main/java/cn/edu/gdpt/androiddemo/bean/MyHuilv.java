package cn.edu.gdpt.androiddemo.bean;

import java.util.List;

public class MyHuilv {
    private List<DataBean> dataBeans;

    public List<DataBean> getDataBeans() {
        return dataBeans;
    }

    public void setDataBeans(List<DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    public  class DataBean {
        /**
         * name : 英镑
         * fBuyPri : 1001.430
         * mBuyPri : 970.510
         * fSellPri : 1009.480
         * mSellPri : 1009.480
         * bankConversionPri : 1014.870
         * date : 2012-12-13
         * time : 16:25:49
         */
        private int drawable;
        private String name;
        private String fBuyPri;
        private String mBuyPri;
        private String fSellPri;
        private String mSellPri;
        private String bankConversionPri;
        private String date;
        private String time;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFBuyPri() {
            return fBuyPri;
        }

        public void setFBuyPri(String fBuyPri) {
            this.fBuyPri = fBuyPri;
        }

        public String getMBuyPri() {
            return mBuyPri;
        }

        public void setMBuyPri(String mBuyPri) {
            this.mBuyPri = mBuyPri;
        }

        public String getFSellPri() {
            return fSellPri;
        }

        public void setFSellPri(String fSellPri) {
            this.fSellPri = fSellPri;
        }

        public String getMSellPri() {
            return mSellPri;
        }

        public void setMSellPri(String mSellPri) {
            this.mSellPri = mSellPri;
        }

        public String getBankConversionPri() {
            return bankConversionPri;
        }

        public void setBankConversionPri(String bankConversionPri) {
            this.bankConversionPri = bankConversionPri;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    }
