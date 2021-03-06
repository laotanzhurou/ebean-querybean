package org.example.domain.typequery;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PEnum;
import io.ebean.typequery.PUtilDate;
import org.example.domain.Customer;
import org.example.domain.Customer.Status;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import org.example.domain.typequery.assoc.QAssocContact;


public class QCustomer extends TQRootBean<Customer,QCustomer> {

  private static final QCustomer _alias = new QCustomer(true);

  public static QCustomer alias() {
    return _alias;
  }

  public PLong<QCustomer> id;

  public PString<QCustomer> name;

  public PBoolean<QCustomer> inactive;

  public PEnum<QCustomer,Status> status;

  public PUtilDate<QCustomer> registered;

  public QAssocContact<QCustomer> contacts;

  public QCustomer() {
    this(Ebean.getDefaultServer());
  }

  public QCustomer(EbeanServer server) {
    super(Customer.class, server);
    setRoot(this);
    this.id = new PLong<>("id", this);
    this.name = new PString<>("name", this);
    this.inactive = new PBoolean<>("inactive", this);
    this.status = new PEnum<>("status",this);
    this.registered = new PUtilDate<>("registered", this);
    this.contacts = new QAssocContact<>("contacts", this, 1);
  }

  protected QCustomer(boolean aliasDummy) {
    super(aliasDummy);
    this.id = new PLong<>("id", this);
    this.name = new PString<>("name", this);
    this.status = new PEnum<>("status",this);
    this.registered = new PUtilDate<>("registered", this);
    this.contacts = new QAssocContact<>("contacts", this, 1);
  }
}
