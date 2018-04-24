package com.zht.entity.dyapi;

import java.util.List;

/**这是关于获取直播房间相关信息的bean
 * Created by masterzht on 2018/4/11.
 */
public class Room_Inf {


    /**
     * error : 0
     * data : {"room_id":"643037","room_thumb":"https://rpic.douyucdn.cn/amrpic-180410/643037_2207.jpg","cate_id":"175","cate_name":"音乐","room_name":"成都东郊记忆街头，了解一下","room_status":"2","start_time":"2018-04-10 15:35:50","owner_name":"陈吉强","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201712/04/14/0be61c59306bd1aaffb42f6a2d6c0d70_big.jpg","online":0,"hn":0,"owner_weight":"35314298","fans_num":"280221","gift":[{"id":"1005","name":"超级火箭","type":"2","pc":2000,"gx":20000,"desc":"赠送网站广播并派送鱼丸宝箱","longro":"","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif"},{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","longro":"我们的征途是星辰大海","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","longro":"主播带我飞","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"750","name":"办卡","type":"2","pc":6,"gx":60,"desc":"","longro":"老板，来办张卡吧！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/74c75c59a1e9338d0b25b62546b84b1d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/130dc639eadd4f79b3d9e24ead4b9ced.gif"},{"id":"193","name":"弱鸡","type":"2","pc":0.2,"gx":2,"desc":"","longro":"真是太鶸拉~","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/3cecdd879dc9e9ec5f0c77099201ca94.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/e144b05fd7dec1b194909e02b6dff92f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","longro":"赞一个！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"赠送鱼丸可增加主播热度值","longro":"全新炽火鱼丸，热度劲燃！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1712/5cc0f558fb097c2525b9aca0f2a780d0.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1712/6cd9af665ad9991c92c78a9018092d7c.gif"},{"id":"1027","name":"药丸","type":"2","pc":0.1,"gx":1,"desc":"","longro":"该吃药了！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1708/db316a56b2e4387506d6a018d1399c6b.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1708/11372a465f77b36b4510ab254944ebba.gif"}]}
     */
    private long error;
    private DataGsonBean data;

    public long getError() {
        return error;
    }

    public void setError(long error) {
        this.error = error;
    }

    public DataGsonBean getData() {
        return data;
    }

    public void setData(DataGsonBean data) {
        this.data = data;
    }


    public static class DataGsonBean {
        /**
         * room_id : 643037
         * room_thumb : https://rpic.douyucdn.cn/amrpic-180410/643037_2207.jpg
         * cate_id : 175
         * cate_name : 音乐
         * room_name : 成都东郊记忆街头，了解一下
         * room_status : 2
         * start_time : 2018-04-10 15:35:50
         * owner_name : 陈吉强
         * avatar : https://apic.douyucdn.cn/upload/avanew/face/201712/04/14/0be61c59306bd1aaffb42f6a2d6c0d70_big.jpg
         * online : 0
         * hn : 0
         * owner_weight : 35314298
         * fans_num : 280221
         * gift : [{"id":"1005","name":"超级火箭","type":"2","pc":2000,"gx":20000,"desc":"赠送网站广播并派送鱼丸宝箱","longro":"","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif"},{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","longro":"我们的征途是星辰大海","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","longro":"主播带我飞","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"750","name":"办卡","type":"2","pc":6,"gx":60,"desc":"","longro":"老板，来办张卡吧！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/74c75c59a1e9338d0b25b62546b84b1d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/130dc639eadd4f79b3d9e24ead4b9ced.gif"},{"id":"193","name":"弱鸡","type":"2","pc":0.2,"gx":2,"desc":"","longro":"真是太鶸拉~","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/3cecdd879dc9e9ec5f0c77099201ca94.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/e144b05fd7dec1b194909e02b6dff92f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","longro":"赞一个！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"赠送鱼丸可增加主播热度值","longro":"全新炽火鱼丸，热度劲燃！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1712/5cc0f558fb097c2525b9aca0f2a780d0.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1712/6cd9af665ad9991c92c78a9018092d7c.gif"},{"id":"1027","name":"药丸","type":"2","pc":0.1,"gx":1,"desc":"","longro":"该吃药了！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1708/db316a56b2e4387506d6a018d1399c6b.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1708/11372a465f77b36b4510ab254944ebba.gif"}]
         */

        private String room_id;
        private String room_thumb;
        private String cate_id;
        private String cate_name;
        private String room_name;
        private String room_status;
        private String start_time;
        private String owner_name;
        private String avatar;
        private long online;
        private long hn;
        private String owner_weight;
        private String fans_num;
        private List<GiftGsonBean> gift;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_thumb() {
            return room_thumb;
        }

        public void setRoom_thumb(String room_thumb) {
            this.room_thumb = room_thumb;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_status() {
            return room_status;
        }

        public void setRoom_status(String room_status) {
            this.room_status = room_status;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getOwner_name() {
            return owner_name;
        }

        public void setOwner_name(String owner_name) {
            this.owner_name = owner_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public long getOnline() {
            return online;
        }

        public void setOnline(long online) {
            this.online = online;
        }

        public long getHn() {
            return hn;
        }

        public void setHn(long hn) {
            this.hn = hn;
        }

        public String getOwner_weight() {
            return owner_weight;
        }

        public void setOwner_weight(String owner_weight) {
            this.owner_weight = owner_weight;
        }

        public String getFans_num() {
            return fans_num;
        }

        public void setFans_num(String fans_num) {
            this.fans_num = fans_num;
        }

        public List<GiftGsonBean> getGift() {
            return gift;
        }

        public void setGift(List<GiftGsonBean> gift) {
            this.gift = gift;
        }

        public static class GiftGsonBean {
            /**
             * id : 1005
             * name : 超级火箭
             * type : 2
             * pc : 2000
             * gx : 20000
             * desc : 赠送网站广播并派送鱼丸宝箱
             * longro :
             * mimg : https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png
             * himg : https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif
             */

            private String id;
            private String name;
            private String type;
            private double pc;
            private long gx;
            private String desc;
            private String longro;
            private String mimg;
            private String himg;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public double getPc() {
                return pc;
            }

            public void setPc(long pc) {
                this.pc = pc;
            }

            public long getGx() {
                return gx;
            }

            public void setGx(long gx) {
                this.gx = gx;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getlongro() {
                return longro;
            }

            public void setlongro(String longro) {
                this.longro = longro;
            }

            public String getMimg() {
                return mimg;
            }

            public void setMimg(String mimg) {
                this.mimg = mimg;
            }

            public String getHimg() {
                return himg;
            }

            public void setHimg(String himg) {
                this.himg = himg;
            }
        }
    }
}
