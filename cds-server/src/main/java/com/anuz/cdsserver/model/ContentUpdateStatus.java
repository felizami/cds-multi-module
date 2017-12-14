package com.anuz.cdsserver.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "content_update_status")
public class ContentUpdateStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validDate;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false)
    private Client clientId;
    @JoinColumn(name = "content_id", referencedColumnName = "content_id")
    @ManyToOne(optional = false)
    private Content contentId;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    public ContentUpdateStatus() {
    }

    public ContentUpdateStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public ContentUpdateStatus(Integer statusId, Date validDate) {
        this.statusId = statusId;
        this.validDate = validDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Content getContentId() {
        return contentId;
    }

    public void setContentId(Content contentId) {
        this.contentId = contentId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentUpdateStatus)) {
            return false;
        }
        ContentUpdateStatus other = (ContentUpdateStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContentUpdateStatus{" +
                "statusId=" + statusId +
                ", validDate=" + validDate +
                ", clientId=" + clientId +
                ", contentId=" + contentId +
                ", status=" + status +
                '}';
    }
}
