var table =
    $('#movieTable').DataTable({
        "ajax":  {"url":"/api/movie","dataSrc":""},
        "columns": [
            { "data": "movieNumber" },
            { "data": "movieName" },
            { "data": "watched" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "order": [[0, 'desc']],
        "pageLength": 10,
        "bLengthChange": false,
        "language": {
            "info": "Showing movies _START_ to _END_ of _TOTAL_ "
        }
    } );

function handleMovie(type) {

    var obj = {
        movieNumber: $("#movieNumber").val(),
        movieName:   $("#movieName").val(),
        watched:    $("#watched").val()
    }

    var params = {
        url: "/api/movie",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    };

    switch (type) {
        case 'post':

            params.type = "POST";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#movieModal").modal('toggle');
                // add to DataTable
                var rowNode = table.row.add(result).draw().node();
                // Highlight row (timeout)
                $(rowNode).addClass('table-success');
                setTimeout(function () {
                    $(rowNode).removeClass('table-success');
                }, 3000)
                toastr["success"]('Movie ' + result["movieName"] + ' added.')

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };

            break;

        case 'update':
            params.type = "PUT";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#movieModal").modal('toggle');
                // Refresh DataTable
                table.ajax.reload();
                toastr["success"]('Movie ' + result["movieName"] + ' updated.')

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };

            break;

        case 'delete':
            params.type = "DELETE";
            params.success = function (result) {
                console.log(result);
                // Toggle modal
                $("#movieModal").modal('toggle');
                // Reload DataTable
                table.ajax.reload();
                toastr["success"]('Movie ' + result["movieName"] + ' deleted.')

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };

            break;

    }

    // if($("#addMovie").valid()){
    $.ajax(params);
    //}
}


// Show modal for updating movie
$('#movieTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    console.log(data);
    showMovieModal('modify', data);
});

// Show modal for adding movies
$('#addMovieButton').on('click', function () {
    showMovieModal('add');
});

function showMovieModal(format, data) {
    // Populates inputfields and buttons based on format (String)
    // data id optional.
    switch (format) {
        case 'modify':
            // populate form
            $.each(data, function (key, value) {
                $('#addMovie').find("input[id='" + key + "']").val(value);
            });
            // initialize title and buttons
            $('#modalLabel').html('Edit movie "');
            $('#movieDeleteButton').show();
            $('#movieSaveButton').show();
            $('#movieAddButton').hide();
            break;

        default:
            // empty form
            $(':input', '#addMovie')
                .not(':button, :submit, :reset')
                .val('');
            // initialize title and buttons
            $('#modalLabel').html('Add new movie');
            $('#movieSelectButton').hide();
            $('#movieSaveButton').hide();
            $('#movieAddButton').show();
            break;
    }

    // show modal
    $("#movieModal").modal('toggle');
}