class MobilePhone(phoneNumber: String) {

    val myPhone: String = phoneNumber
    var myContacts: MutableList<Contact> = mutableListOf()

    init {
        myContacts.add(Contact("Me", myPhone))
    }

    fun addNewContact(newContact: Contact) {
        myContacts.add(newContact)
    }

    fun updateContact(oldContact: Contact, newContact: Contact) : Boolean {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == oldContact.name &&
                myContacts[i].phoneNumber == oldContact.phoneNumber) {
                myContacts[i] = newContact
                return true
            }
        }

        return false;
    }

    fun removeContact(removeContact: Contact) : Boolean {
        for (contact in myContacts) {
            if (contact.name == removeContact.name &&
                contact.phoneNumber == removeContact.phoneNumber) {
                myContacts.remove(contact)
                return true;
            }
        }

        return false;
    }

    fun findContact(contact: Contact) : Int {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == contact.name &&
                myContacts[i].phoneNumber == contact.phoneNumber) {
                return i
            }
        }

        return -1
    }

    fun queryContact(name: String) : Contact? {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == name) {
                return myContacts[i]
            }
        }

        return null
    }

    fun printContacts() {
        for (contact in myContacts) {
            println("${contact.name}, ${contact.phoneNumber}")
        }
    }
}