
class MobilePhone(phoneNumber: String) {

    private val myPhone: String = phoneNumber
    private var myContacts: MutableList<Contact> = mutableListOf()

    init {
        myContacts.add(Contact("Me", myPhone))
    }

    fun addNewContact(newContact: Contact) {
        myContacts.add(newContact)
    }

    fun updateContact(oldContact: Contact, newContact: Contact) : Boolean {
        myContacts.forEach {
            if (it.name == oldContact.name && it.phoneNumber == oldContact.phoneNumber) {
                removeContact(it)
                addNewContact(newContact)
                return true
            }
        }

        return false
    }

    fun removeContact(contact: Contact) : Boolean {
        return myContacts.remove(contact)
    }

    fun findContact(contact: Contact) : Int {
        return myContacts.indexOf(contact)
    }

    fun queryContact(name: String) : Contact? {
        myContacts.forEach { contact ->
            if (contact.name == name) return contact
        }

        return null
    }

    fun printContacts() {
        for (contact in myContacts) {
            println("${contact.name}, ${contact.phoneNumber}")
        }
    }
}