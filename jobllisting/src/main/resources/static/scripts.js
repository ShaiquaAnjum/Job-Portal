function searchJobs() {
    var searchText = document.getElementById("searchInput").value;

    // Make AJAX request to backend API
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/posts/" + searchText, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var results = JSON.parse(xhr.responseText);
                displaySearchResults(results);
            } else {
                console.error("Failed to fetch search results.");
            }
        }
    };
    xhr.send();
}

function displaySearchResults(results) {
    var searchResultsList = document.getElementById("searchResults");
    searchResultsList.innerHTML = "";

    results.forEach(function(result) {
        var listItem = document.createElement("li");
        listItem.classList.add("job-item");
        listItem.innerHTML = `
            <h2>${result.profile}</h2>
            <p><strong>Description:</strong> ${result.desc}</p>
            <p><strong>Experience:</strong> ${result.exp}</p>
            <p><strong>Technologies:</strong> ${result.techs.join(", ")}</p>
        `;
        searchResultsList.appendChild(listItem);
    });
}
