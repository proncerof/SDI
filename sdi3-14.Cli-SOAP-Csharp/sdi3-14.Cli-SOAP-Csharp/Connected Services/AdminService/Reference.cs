﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace sdi3_14.Cli_SOAP_Csharp.AdminService {
    
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class BusinessException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class task : object, System.ComponentModel.INotifyPropertyChanged {
        
        private category categoryField;
        
        private string commentsField;
        
        private System.DateTime createdField;
        
        private bool createdFieldSpecified;
        
        private System.DateTime finishedField;
        
        private bool finishedFieldSpecified;
        
        private long idField;
        
        private bool idFieldSpecified;
        
        private System.DateTime plannedField;
        
        private bool plannedFieldSpecified;
        
        private string titleField;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public category category {
            get {
                return this.categoryField;
            }
            set {
                this.categoryField = value;
                this.RaisePropertyChanged("category");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string comments {
            get {
                return this.commentsField;
            }
            set {
                this.commentsField = value;
                this.RaisePropertyChanged("comments");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public System.DateTime created {
            get {
                return this.createdField;
            }
            set {
                this.createdField = value;
                this.RaisePropertyChanged("created");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool createdSpecified {
            get {
                return this.createdFieldSpecified;
            }
            set {
                this.createdFieldSpecified = value;
                this.RaisePropertyChanged("createdSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public System.DateTime finished {
            get {
                return this.finishedField;
            }
            set {
                this.finishedField = value;
                this.RaisePropertyChanged("finished");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool finishedSpecified {
            get {
                return this.finishedFieldSpecified;
            }
            set {
                this.finishedFieldSpecified = value;
                this.RaisePropertyChanged("finishedSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public long id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool idSpecified {
            get {
                return this.idFieldSpecified;
            }
            set {
                this.idFieldSpecified = value;
                this.RaisePropertyChanged("idSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public System.DateTime planned {
            get {
                return this.plannedField;
            }
            set {
                this.plannedField = value;
                this.RaisePropertyChanged("planned");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool plannedSpecified {
            get {
                return this.plannedFieldSpecified;
            }
            set {
                this.plannedFieldSpecified = value;
                this.RaisePropertyChanged("plannedSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public string title {
            get {
                return this.titleField;
            }
            set {
                this.titleField = value;
                this.RaisePropertyChanged("title");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class category : object, System.ComponentModel.INotifyPropertyChanged {
        
        private long idField;
        
        private bool idFieldSpecified;
        
        private string nameField;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public long id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool idSpecified {
            get {
                return this.idFieldSpecified;
            }
            set {
                this.idFieldSpecified = value;
                this.RaisePropertyChanged("idSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
                this.RaisePropertyChanged("name");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public partial class user : object, System.ComponentModel.INotifyPropertyChanged {
        
        private category[] categoriesField;
        
        private task[] tasksField;
        
        private string emailField;
        
        private long idField;
        
        private bool idFieldSpecified;
        
        private bool isAdminField;
        
        private bool isAdminFieldSpecified;
        
        private string loginField;
        
        private string passwordField;
        
        private userStatus statusField;
        
        private bool statusFieldSpecified;
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute("categories", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=0)]
        public category[] categories {
            get {
                return this.categoriesField;
            }
            set {
                this.categoriesField = value;
                this.RaisePropertyChanged("categories");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute("tasks", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=1)]
        public task[] tasks {
            get {
                return this.tasksField;
            }
            set {
                this.tasksField = value;
                this.RaisePropertyChanged("tasks");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string email {
            get {
                return this.emailField;
            }
            set {
                this.emailField = value;
                this.RaisePropertyChanged("email");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public long id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool idSpecified {
            get {
                return this.idFieldSpecified;
            }
            set {
                this.idFieldSpecified = value;
                this.RaisePropertyChanged("idSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public bool isAdmin {
            get {
                return this.isAdminField;
            }
            set {
                this.isAdminField = value;
                this.RaisePropertyChanged("isAdmin");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool isAdminSpecified {
            get {
                return this.isAdminFieldSpecified;
            }
            set {
                this.isAdminFieldSpecified = value;
                this.RaisePropertyChanged("isAdminSpecified");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public string login {
            get {
                return this.loginField;
            }
            set {
                this.loginField = value;
                this.RaisePropertyChanged("login");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
                this.RaisePropertyChanged("password");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=7)]
        public userStatus status {
            get {
                return this.statusField;
            }
            set {
                this.statusField = value;
                this.RaisePropertyChanged("status");
            }
        }
        
        /// <comentarios/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool statusSpecified {
            get {
                return this.statusFieldSpecified;
            }
            set {
                this.statusFieldSpecified = value;
                this.RaisePropertyChanged("statusSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <comentarios/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://admin.impl.business.sdi.uo/")]
    public enum userStatus {
        
        /// <comentarios/>
        ENABLED,
        
        /// <comentarios/>
        DISABLED,
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://admin.impl.business.sdi.uo/", ConfigurationName="AdminService.AdminService")]
    public interface AdminService {
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse findUserById(sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse> findUserByIdAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById request);
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse disableUser(sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse> disableUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser request);
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse enableUser(sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse> enableUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse findAllUsers(sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse> findAllUsersAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        void reseteaDB();
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task reseteaDBAsync();
        
        // CODEGEN: El parámetro 'arg0' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.FaultContractAttribute(typeof(sdi3_14.Cli_SOAP_Csharp.AdminService.BusinessException), Action="", Name="BusinessException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse deepDeleteUser(sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse> deepDeleteUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findUserById", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findUserById {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public findUserById() {
        }
        
        public findUserById(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findUserByIdResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findUserByIdResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public sdi3_14.Cli_SOAP_Csharp.AdminService.user @return;
        
        public findUserByIdResponse() {
        }
        
        public findUserByIdResponse(sdi3_14.Cli_SOAP_Csharp.AdminService.user @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="disableUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class disableUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public disableUser() {
        }
        
        public disableUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="disableUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class disableUserResponse {
        
        public disableUserResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="enableUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class enableUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public enableUser() {
        }
        
        public enableUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="enableUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class enableUserResponse {
        
        public enableUserResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsers", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsers {
        
        public findAllUsers() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="findAllUsersResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class findAllUsersResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public sdi3_14.Cli_SOAP_Csharp.AdminService.user[] @return;
        
        public findAllUsersResponse() {
        }
        
        public findAllUsersResponse(sdi3_14.Cli_SOAP_Csharp.AdminService.user[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="deepDeleteUser", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class deepDeleteUser {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://admin.impl.business.sdi.uo/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public long arg0;
        
        public deepDeleteUser() {
        }
        
        public deepDeleteUser(long arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="deepDeleteUserResponse", WrapperNamespace="http://admin.impl.business.sdi.uo/", IsWrapped=true)]
    public partial class deepDeleteUserResponse {
        
        public deepDeleteUserResponse() {
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface AdminServiceChannel : sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class AdminServiceClient : System.ServiceModel.ClientBase<sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService>, sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService {
        
        public AdminServiceClient() {
        }
        
        public AdminServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public AdminServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AdminServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AdminServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.findUserById(sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById request) {
            return base.Channel.findUserById(request);
        }
        
        public sdi3_14.Cli_SOAP_Csharp.AdminService.user findUserById(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById();
            inValue.arg0 = arg0;
            sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse retVal = ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).findUserById(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse> sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.findUserByIdAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById request) {
            return base.Channel.findUserByIdAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findUserByIdResponse> findUserByIdAsync(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.findUserById();
            inValue.arg0 = arg0;
            return ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).findUserByIdAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.disableUser(sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser request) {
            return base.Channel.disableUser(request);
        }
        
        public void disableUser(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser();
            inValue.arg0 = arg0;
            sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse retVal = ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).disableUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse> sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.disableUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser request) {
            return base.Channel.disableUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.disableUserResponse> disableUserAsync(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.disableUser();
            inValue.arg0 = arg0;
            return ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).disableUserAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.enableUser(sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser request) {
            return base.Channel.enableUser(request);
        }
        
        public void enableUser(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser();
            inValue.arg0 = arg0;
            sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse retVal = ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).enableUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse> sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.enableUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser request) {
            return base.Channel.enableUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.enableUserResponse> enableUserAsync(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.enableUser();
            inValue.arg0 = arg0;
            return ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).enableUserAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.findAllUsers(sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers request) {
            return base.Channel.findAllUsers(request);
        }
        
        public sdi3_14.Cli_SOAP_Csharp.AdminService.user[] findAllUsers() {
            sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers();
            sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse retVal = ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).findAllUsers(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse> sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.findAllUsersAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers request) {
            return base.Channel.findAllUsersAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsersResponse> findAllUsersAsync() {
            sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.findAllUsers();
            return ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).findAllUsersAsync(inValue);
        }
        
        public void reseteaDB() {
            base.Channel.reseteaDB();
        }
        
        public System.Threading.Tasks.Task reseteaDBAsync() {
            return base.Channel.reseteaDBAsync();
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.deepDeleteUser(sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser request) {
            return base.Channel.deepDeleteUser(request);
        }
        
        public void deepDeleteUser(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser();
            inValue.arg0 = arg0;
            sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse retVal = ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).deepDeleteUser(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse> sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService.deepDeleteUserAsync(sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser request) {
            return base.Channel.deepDeleteUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUserResponse> deepDeleteUserAsync(long arg0) {
            sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser inValue = new sdi3_14.Cli_SOAP_Csharp.AdminService.deepDeleteUser();
            inValue.arg0 = arg0;
            return ((sdi3_14.Cli_SOAP_Csharp.AdminService.AdminService)(this)).deepDeleteUserAsync(inValue);
        }
    }
}