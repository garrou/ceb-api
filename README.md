# ceb-api

Compte est bon REST api

## [Try it](https://ceb-ui.herokuapp.com)

## Example

```js
const request = {
    operands: [78, 7, 6, 5, 2, 3],
    goal: 435
};
const response = await fetch('https://ceb-api.herokuapp.com/api/v1/ceb', {
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify(request)
});
```