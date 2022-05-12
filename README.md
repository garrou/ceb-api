# ceb-api

Compte est bon REST api

## Example

```js
const request = {
    operands: [78, 7, 6, 5, 2, 3],
    goal: 435
};
const response = await fetch('http://localhost:8080/api/v1/ceb', {
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify(request)
});
```