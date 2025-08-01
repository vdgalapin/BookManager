document.addEventListener("DOMContentLoaded", loadBooks);

document.getElementById("bookForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const datePublished = document.getElementById("datePublished").value;

    fetch("/books", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ title, author, datePublished }),
    }). then(res => res.json())
    .then(() => {
        loadBooks();
        document.getElementById("bookForm").reset();
    });
});

function loadBooks() {
    fetch("/books")
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("bookList");
            list.innerHTML = "";
            data.forEach(book => {
                const row = `<tr>
                                <td>${book.id}</td>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.datePublished}</td>
                            </tr>`;
                list.innerHTML += row;
            });
        })
}