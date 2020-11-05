function showDatabase(_data, databaseName, tableHeader) {
    const data = _data
    const table = document.createElement('table');
    const h1 = document.createElement('h1')
    h1.appendChild(document.createTextNode("数据库" + databaseName + "信息"))
    h1.align = "center"
    table.border = "1"
    table.align = "center"

    const tableBody = document.createElement('tbody')
    table.appendChild(tableBody)
    tableBody.insertRow(0)
    //const tableHeader = ["username", "name", "age", "teleno"]
    const tableHeaderLength = tableHeader.length
    for (let i = 0; i < tableHeaderLength; i++) {
        tableBody.rows[0].insertCell(i)
        tableBody.rows[0].cells[i].appendChild(document.createTextNode(tableHeader[i]))
    }
    const dataLength = data.length
    for (let row = 1; row <= dataLength; row++) {
        tableBody.insertRow(row)
        for (let column = 0; column < tableHeaderLength; column++) {
            tableBody.rows[row].insertCell(column)
            switch (column) {
                case 0:
                    tableBody.rows[row].cells[column].appendChild(document.createTextNode(data[row - 1].username))
                    break
                case 1:
                    if (tableHeaderLength === 4) {
                        // 代表是person，需要用name
                        //console.log(11)
                        //console.log(data[row - 1].name)
                        tableBody.rows[row].cells[column].appendChild(document.createTextNode(data[row - 1].name))
                    } else {
                        // 代表是user，需要用pass
                        //console.log(22)
                        //console.log(data[row - 1].pass)
                        tableBody.rows[row].cells[column].appendChild(document.createTextNode(data[row - 1].pass))
                    }
                    break
                case 2:
                    tableBody.rows[row].cells[column].appendChild(document.createTextNode(data[row - 1].age))
                    break
                case 3:
                    tableBody.rows[row].cells[column].appendChild(document.createTextNode(data[row - 1].teleno))
                    break
            }
        }
    }
    document.body.appendChild(h1)
    document.body.appendChild(table)
}

function getMapping() {
    getPersonMapping()
    getUsersMapping()
}