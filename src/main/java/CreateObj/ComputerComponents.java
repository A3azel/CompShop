package CreateObj;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ComputerComponents implements Serializable {
    private int componentID;
    private String componentCategory;
    private String componentName;
    private String componentDescription;
    private String componentPhotoURL;
    private BigDecimal componentPrise;
    private int componentCount;

    public ComputerComponents(){

    }

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public String getComponentCategory() {
        return componentCategory;
    }

    public void setComponentCategory(String componentCategory) {
        this.componentCategory = componentCategory;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public String getComponentPhotoURL() {
        return "CompPhotos/" + componentCategory + "/" + componentPhotoURL + ".jpg";
    }

    public void setComponentPhotoURL(String componentPhotoURL) {
        this.componentPhotoURL = componentPhotoURL;
    }

    public BigDecimal getComponentPrise() {
        return componentPrise;
    }

    public void setComponentPrise(BigDecimal componentPrise) {
        this.componentPrise = componentPrise;
    }

    public int getComponentCount() {
        return componentCount;
    }

    public void setComponentCount(int componentCount) {
        this.componentCount = componentCount;
    }

    @Override
    public String toString() {
        return "ComputerComponents{" +
                "componentCategory='" + componentCategory + '\'' +
                ", componentName='" + componentName + '\'' +
                ", componentDescription='" + componentDescription + '\'' +
                ", componentPhotoURL='" + componentPhotoURL + '\'' +
                ", componentPrise=" + componentPrise +
                ", componentCount=" + componentCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerComponents)) return false;
        ComputerComponents that = (ComputerComponents) o;
        return componentID == that.componentID && componentCount == that.componentCount && Objects.equals(componentCategory, that.componentCategory) && Objects.equals(componentName, that.componentName) && Objects.equals(componentDescription, that.componentDescription) && Objects.equals(componentPhotoURL, that.componentPhotoURL) && Objects.equals(componentPrise, that.componentPrise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentID, componentCategory, componentName, componentDescription, componentPhotoURL, componentPrise, componentCount);
    }
}
