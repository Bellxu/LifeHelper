package com.lifehelper.android.bean;

import java.io.Serializable;
import java.util.List;

public class SearchCookBean implements Serializable {

    private static final long serialVersionUID = -79321922814811620L;
    /**
     * id
     */
    private int id;
    /**
     * classid
     */
    private int classid;
    /**
     * name
     */
    private String name;
    /**
     * peoplenum
     */
    private String peoplenum;
    /**
     * preparetime
     */
    private String preparetime;
    /**
     * cookingtime
     */
    private String cookingtime;
    /**
     * content
     */
    private String content;
    /**
     * pic
     */
    private String pic;
    /**
     * tag
     */
    private String tag;
    /**
     * material
     */
    private List<MaterialDTO> material;
    /**
     * process
     */
    private List<ProcessDTO> process;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getPreparetime() {
        return preparetime;
    }

    public void setPreparetime(String preparetime) {
        this.preparetime = preparetime;
    }

    public String getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(String cookingtime) {
        this.cookingtime = cookingtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<MaterialDTO> getMaterial() {
        return material;
    }

    public void setMaterial(List<MaterialDTO> material) {
        this.material = material;
    }

    public List<ProcessDTO> getProcess() {
        return process;
    }

    public void setProcess(List<ProcessDTO> process) {
        this.process = process;
    }

    public static class MaterialDTO {
        /**
         * mname
         */
        private String mname;
        /**
         * type
         */
        private int type;
        /**
         * amount
         */
        private String amount;

        public String getMname() {
            return mname;
        }

        public void setMname(String mname) {
            this.mname = mname;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }

    public static class ProcessDTO {
        /**
         * pcontent
         */
        private String pcontent;
        /**
         * pic
         */
        private String pic;

        public String getPcontent() {
            return pcontent;
        }

        public void setPcontent(String pcontent) {
            this.pcontent = pcontent;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
