if op==3:
    import pymysql

    db = pymysql.connect(host='localhost',
                     user='root',
                     password='123456',
                     database='first_task',
                     charset='utf8')

    cursor = db.cursor()

    try:
        sql = "update student set progress='20%' where id="+id
        cursor.execute(sql)
        db.commit()
        cursor.close()
        db.close()
        print("Save successfully")
    except:
        print("Save failed")
else:
    pass
