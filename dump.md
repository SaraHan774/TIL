#### What is dump method?

If your database is large or takes too long to pack, dumping a database is the preferred backup method. This method creates a dump ( . dmp ) file containing only the database metadata, instead of producing a pack file that contains the file system data as well as the metadata.

#### What is dump and load?

load would take a file-like object, read the data from that object, and use that string to create an object: with open(‘file.json’) as fh: a = json.load(fh) Note that dump and load convert between **files** and objects, while dump**s** and load**s** convert between **strings** and objects.